USE TMDB;
-- 트렌드 데이터 임포트 스크립트
set @counter=0;
LOAD DATA INFILE './TMDB_TREND_DUMMY_DATA.csv' -- 경로를 변경해서 사용해주세요.
INTO TABLE trend
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS
(@movie_id,@create_date)
SET
	id=@counter:=@counter+1,
    movie_id = @movie_id,
    created_date= @create_date
