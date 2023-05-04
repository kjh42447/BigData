# 빅데이터 전체 흐름

정확하지는 않지만 이해한대로 정리

### Data
- Data Lake : 텍스트, 이미지, 영상 등등 모든 데이터를 모아둔 저장소. 

### DB
- hadoop : 방대한 양의 데이터를 빠르게 처리할 수 있도록 도와주는 오픈소스. 수많은 클러스터로 나누어 저장하기에 빠른 속도 가능.

### DBMS
- hive, hbase : hadoop 등의 빅데이터용 DB의 데이터를 처리하기 위한 오픈소스.

### 검색엔진
- solr, elasticsearch : 데이터의 양이 방대하므로 빠른 검색이 필수적이기에 사용하는 오픈소스.

### DBMS 편의성 개선 
- atlas : hive 등의 dbms의 crud 작업 등을 간편하게 처리하기 위한 오픈소스.

### 전체 흐름 정리

Data Lake의 방대한 데이터를 빠르고 효율적으로 관리하기 위해 hadoop 등의 DB를 사용.
그에 해당하는 DBMS로 hive, hbase 등이 있고,  ui적으로 개선되고 사용하기 편한 atlas가 있다.
또한 검색 속도가 매우 중요하므로 solr, elasticsearch등의 검색엔진도 사용.