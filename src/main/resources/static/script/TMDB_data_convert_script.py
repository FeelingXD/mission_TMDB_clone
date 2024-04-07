import csv

folder_path="./csv_data"
origin_file_path = "/TMDB_movie_dataset.csv"
modified_file_path = "/movies_example_modified.csv"

get_first_data_split_by_com:str=lambda x:x.split(',')[0]


if __name__=="__main__":
    with open(folder_path+origin_file_path, "r") as fr, open(folder_path+modified_file_path, "w", newline="") as fw:
        rdr = csv.reader(fr)
        modified_header_row = [
            "id",
            "title",
            "poster_path",
            "status",
            "genre",
            "overview",
            "budget",
            "revenue",
            "production_country",
            "production_company",
            "vote_count",
            "vote_average",
            "release_date",
            "language",
        ]

        # 파일쓰기
        writer = csv.writer(fw)
        writer.writerow(modified_header_row)
        for idx, line in enumerate(rdr, 0):
            if idx ==0: # 기존 헤더정보 스킵 
                continue
            if idx > 5000:  # 5000 개 데이터 만 사용
                break

            (
                movie_id,
                title,
                vote_average,
                vote_count,
                status,
                release_date,
                revenue,
                runtime,
                adult,
                backdrop_path,
                budget,
                homepage,
                imdb_id,
                original_language,
                original_title,
                overview,
                popularity,
                poster_path,
                tagline,
                genres,
                production_companies,
                production_countries,
                spoken_languages,
                keywords,
            ) = line

            """
             genre를 단일 장르로 변경
            """

            genre = get_first_data_split_by_com(genres)
            """
            "id",
            "title",
            "poster_path",
            "status",
            "genre",
            "overview",
            "budget",
            "revenue",
            "production_country",
            "production_company",
            "vote_count",
            "vote_average",
            "release_date",
            "language",
            """
            write_line=[movie_id,title,poster_path,status,genre,overview,budget,revenue,production_companies,production_companies,vote_count,vote_average,release_date,original_language]
            writer.writerow(write_line)  
    print("script done!")