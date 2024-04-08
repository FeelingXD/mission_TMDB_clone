USE TMDB;
-- 트레일러 데이터 임포트 스크립트
LOAD DATA INFILE './TMDB_PLATFORM_TYPE_DUMMY_DATA' -- 경로를 변경해서 사용해주세요.
INTO TABLE movie
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS
(@movie_id,@platform)
SET
    movie_id = @movie_id,
    platform = @platform
