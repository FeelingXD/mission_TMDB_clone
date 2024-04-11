USE TMDB;
-- 트레일러 데이터 임포트 스크립트
LOAD DATA INFILE './TMDB_TRAILER_DUMMY_DATA.csv' -- 경로를 변경해서 사용해주세요.
INTO TABLE trailer
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS
(@movie_id,@trailer_overview,@trailer_title,@trailer_url)
SET
    movie_id  = @movie_id,
    trailer_overview=@trailer_overview
    trailer_title=@trailer_title
    trailer_url=@trailer_url
    