import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        return calculateMusic(genres, plays);
    }
    
    public int[] calculateMusic (String[] genres, int[] plays) {
        HashMap<String, Genre> map = new HashMap<>();
        for(int i = 0; i < genres.length; i++){
            Genre genre = map.getOrDefault(genres[i], new Genre());
            Music music = new Music(genres[i], plays[i], i);
            genre.addMusic(music);
            map.put(genres[i], genre);
        }
        List<Genre> genrelist = new ArrayList<>(map.values());
        Collections.sort(genrelist);
        for(String key : map.keySet()) {
            map.get(key).sortList();
        }
        
        ArrayList<Integer> resultArray = new ArrayList<>();
        for(Genre genre: genrelist) {
            int cnt = 0;
            for (Music music : genre.array) {
                if (cnt == 2) {
                    break;
                }
                resultArray.add(music.originNumber);
                cnt++;
            }
        }
        return listToIntArray(resultArray);
    } 
    
    public int[] listToIntArray(List<Integer> integerList) {
        int[] array = new int[integerList.size()];
        
        int idx = 0;
        for(int i : integerList) {
            array[idx] = i;
            idx++;
        }
        return array;
    }
        
        
    static class Genre implements Comparable<Genre> {
        ArrayList<Music> array = new ArrayList<>();
        int number;
        
        public Genre() {
            this.number = 0;
        }
        public void addMusic(Music music) {
            this.number += music.number;
            array.add(music);
        }
        public void sortList() {
            Collections.sort(array);
        }
        
        @Override
        public int compareTo(Genre o){
            return o.number - this.number;
        }
    }
    
    static class Music implements Comparable<Music> {
        String type;
        int number;
        int originNumber;
        
        public Music(String type, int number, int originNumber){
            this.type = type;
            this.number = number;
            this.originNumber = originNumber;
        }
        
        @Override
        public int compareTo (Music o){
            if (this.number == o.number) {
                return this.originNumber - o.originNumber;
            }
            return o.number - this.number;
        }
    }      
}