import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> result = new ArrayList<>();
        
        // 장르별 재생 횟수 저장
        Map<String, Long> genreCount = new HashMap<>();
        
        // 장르별 음악 저장 ( 장르 : (고유번호, 재생횟수) )
        Map<String, List<List<Integer>>> genreMusic = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            List<List<Integer>> musics = genreMusic.getOrDefault(genres[i], new ArrayList<>());
            List<Integer> music = List.of(i, plays[i]);
            musics.add(music);
            genreMusic.put(genres[i], musics);
            genreCount.put(genres[i], genreCount.getOrDefault(genres[i], 0L) + plays[i]);
        }

        // 장르별 음악을 재생 횟수에 따라 정렬
        for (String genre : genreMusic.keySet()) {
            List<List<Integer>> musics = genreMusic.get(genre);
            musics.sort((o1, o2) -> o2.get(1).compareTo(o1.get(1)));
            genreMusic.put(genre, musics);
        }
        
        // 총 재생 횟수에 따라 장르를 정렬
        List<Map.Entry<String, Long>> entryList = new ArrayList<>();
        for (Map.Entry<String, Long> entry : genreCount.entrySet()) {
            entryList = new ArrayList<>(genreCount.entrySet());
            entryList.sort((entry1, entry2) -> Long.compare(entry2.getValue(), entry1.getValue()));
        }
        
        // 장르별로 순회하며 2개씩 앨범에 추가
        for (Map.Entry<String, Long> entry : entryList) {
            List<List<Integer>> musics = genreMusic.get(entry.getKey());
            for (int i = 0; (i < 2) && (i < musics.size()); i++) {
                result.add(musics.get(i).get(0));
            }
        }
        
        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}