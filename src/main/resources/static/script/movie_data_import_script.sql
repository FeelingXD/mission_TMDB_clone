USE TMDB;

LOAD DATA INFILE './movies_example_modified.csv' -- 경로를 변경해서 사용해주세요.
INTO TABLE movie
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS
(@id, @title, @poster_path, @status, @genre, @overview, @budget, @revenue, @production_countries, @production_companies, @vote_count, @vote_average, @release_date, @language)
SET
  id = @id,
  title = @title,
  poster_path = @poster_path,
  status = @status,
  genre = @genre,
  overview = @overview,
  budget = @budget,
  revenue = @revenue,
  production_countries = @production_countries,
  production_companies = @production_companies,
  vote_count = @vote_count,
  vote_average = @vote_average,
  release_date = STR_TO_DATE(@release_date, '%Y-%m-%d'),
  language = @language;
