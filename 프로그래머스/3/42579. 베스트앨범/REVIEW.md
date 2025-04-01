#Coding-Test 

---

# 베스트앨범

---

### 접근

처음에 가장 많이 재생된 장르에서만 2곡을 고르는 것으로 문제를 잘못 이해해 풀이에 시간
이 오래 걸렸다. 코드를 작성하기 전에 문제의 입출력 예시를 좀 더 꼼꼼하게 살펴봐야겠다.

1. 장르별 재생 횟수를 Map으로 저장한다. `(장르 : 재생 횟수)`
2. 장르별 음악을 Map으로 저장한다. `(장르 : (고유 번호, 재생 횟수))`
3. (2)에서 저장한 Map의 value `(고유 번호, 재생 횟수)` 리스트를 음악의 재생 횟수로 정렬한다.
4. 총 재생 횟수에 따라 장르를 역순 정렬해 리스트로 저장한다. `List<Map.Entry<String, Long>>`
5. (4)의 장르 리스트를 순회하면서 (2)에서 해당 장르의 음악을 2개씩 앨범에 추가한다.

---

### 알게된 내용

- `Map`은 기본적으로 정렬이 보장되지 않아 `Stream`으로 **Key**/**Value**기준 정렬할 수 있다.
- **`Map<String, Integer>`을 Value 기준 오름차순 정렬**

```java
Map<String, Integer> map = new HashMap<>();
map.put("Charlie", 3);
map.put("Alice", 1);
map.put("Bob", 2);

LinkedHashMap<String, Integer> sortedByValue = map.entrySet().stream()
			  .sorted(Map.Entry.comparingByValue())
			  .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, 
				  (e1, e2) -> e1, LinkedHashMap::new));

List<Map.Entry<String, Integer>> sortedByValueList = map.entrySet().stream()
            .sorted(Map.Entry.comparingByValue())
            .collect(Collectors.toList());
```

- **`Map<String, Integer>`을 Value 기준 내림차순 정렬**

```java
LinkedHashMap<String, Integer> sortedDescByValue = map.entrySet().stream()
			.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
			.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, 
				  (e1, e2) -> e1, LinkedHashMap::new));

List<Map.Entry<String, Integer>> sortedDescByValueList = map.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .collect(Collectors.toList());
```

`LinkedHashMap` : **`Map`을 계속 사용해야 할 경우** (순서 유지비용 때문에 성능은 좋지 않음) `List<Map.Entry<>>` : **정렬된 데이터를 단순히 처리하고 결과만 필요할 때**

---

### 풀이

```java
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
```
