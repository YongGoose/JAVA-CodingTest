import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        return calculateMusic(genres, plays);
    }
    
    public int[] calculateMusic (String[] genres, int[] plays) {
        HashMap<String, Genre> map = new HashMap<>();        
        for(int i = 0; i < genres.length; i++){
            Genre genre = map.getOrDefault(genres[i], new Genre());
            genre.addMusic(new Music(plays[i], i));
            map.put(genres[i], genre);
        }
        
        List<Genre> genrelist = new ArrayList<>(map.values());
        Collections.sort(genrelist);
        
        ArrayList<Integer> resultArray = new ArrayList<>();
        for(Genre genre: genrelist) {
            for(Music music : genre.getTopTwo()) {
                resultArray.add(music.originNumber);
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
        
        public List<Music> getTopTwo() {
            Collections.sort(array);
            return array.subList(0, Math.min(array.size(), 2));
        }
        
        @Override
        public int compareTo(Genre o){
            return o.number - this.number;
        }
    }
    
    static class Music implements Comparable<Music> {
        int number;
        int originNumber;
        
        public Music(int number, int originNumber){
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