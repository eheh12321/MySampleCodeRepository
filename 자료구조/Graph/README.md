# Graph :chart_with_upwards_trend:
여러개의 노드들이 서로 연결되어있는 관계를 표현한 비선형 자료구조
<br>

## 그래프 용어
- `Vertex`(정점): 노드(원소)
- `Edge`(간선): 정점과 정점을 연결하는 선
- adjacent vertex: 인접 정점
- `Weighted Graph`: 가중치 그래프
- `Directed Graph`: 단방향 그래프
- `Undirected Graph`: 양방향 그래프
- `Cycle`: 한 정점에서 출발해 다시 해당 정점으로 돌아오는 경로가 존재하는 경우
- `Self loop`: 정점의 간선이 자기 자신을 가리키는 경우
<br>

## 그래프 표현 방식
- 인접 행렬 (Adjacency Matrix): 이차원 배열을 이용해 그래프의 연결관계 표현
  - 만들기 쉬움
  - 메모리 낭비 O
- 인접 리스트 (Adjacency list): LinkedList를 이용해 그래프의 연결관계 표현
  - 구현은 어려운 편
  - 효율적인 메모리 사용
<br>

## 그래프 순회 :star:
- 깊이 우선 탐색 (Depth-First Search, DFS)
  - `스택`, `재귀`를 통한 구현
  - `최적해`를 보장하지 않음
  - 현재 경로상의 노드만 기억하기 때문에 상대적으로 적은 메모리 사용
  - `백트래킹` 알고리즘에 사용되는 방식
- 너비 우선 탐색 (Breath-First Search, BFS)
  - `큐`를 통한 구현
  - `최적해` 탐색을 보장하기 때문에 `최단경로` 탐색 시 사용 