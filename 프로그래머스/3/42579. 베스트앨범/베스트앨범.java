import java.util.*;

class Solution {
	public int[] solution(String[] genres, int[] plays) {
		Map<String, List<Music>> map = new HashMap<>();

		for(int i = 0; i < plays.length; i++) {
			map.put(genres[i], map.getOrDefault(genres[i], new ArrayList<>()));
			map.get(genres[i]).add(new Music(i, plays[i]));
		}
        
        Set<String> keySet = map.keySet();
        List<SortedGenre> genreList = new ArrayList<>();
        for(String key : keySet) {
            List<Music> q = map.get(key);
            int num = 0;
            
            for(Music m : q) {
                num += m.play;
            }
            genreList.add(new SortedGenre(key, num));
        }
        
        Collections.sort(genreList);
        
        List<Integer> resultList = new ArrayList<>();
        for(SortedGenre genre : genreList) {
            String currentGenre = genre.genre;
            List<Music> musicList = map.get(currentGenre);
            Collections.sort(musicList);
            
            for(int i = 0; i < Math.min(2, musicList.size()); i++) {
                if(map.get(currentGenre).isEmpty()) {
                    break;
                }
                resultList.add(musicList.get(i).originNum);
            }
        }

		int[] answer = resultList.stream().mapToInt(i -> i).toArray();
		return answer;
	}

	static class Music implements Comparable<Music> {
		int originNum;
		int play;

		public Music(final int originNum, final int play) {
			this.originNum = originNum;
			this.play = play;
		}
        
        @Override
        public int compareTo(Music o) {
            if(this.play == o.play) {
                return this.originNum - o.originNum;
            }
            return o.play - this.play;
        }
	}
    
    static class SortedGenre implements Comparable<SortedGenre> {
        String genre;
        int plays;
        
        public SortedGenre (final String genre, final int plays) {
            this.genre = genre;
            this.plays = plays;
        }
        
        @Override
        public int compareTo(SortedGenre o) {
            return o.plays - this.plays;
        }
    }
}