import csv

'''
    TMDB DB trailer 테이블의 더미 데이터를 만들기 위한 스크립트입니다.
'''

FOLDER_PACKAGE = "./csv_data/"
INPUT_FILENAME = "movies_example_modified.csv"
OUTPUT_FILENAME = "TMDB_TRAILER_DUMMY_DATA.csv"
TMDB_TRAILER_TABLE_HEADER = ['movie_id', 'trailer_overview', 'trailer_title', 'trailer_url']

DUMMY_OVERVIEW_TEXT = "개요 :"
DUMMY_OVERVIEW_URL = "/trailer/"
DUMMY_TRAILER_TITLE_TEXT = "TRAILER: "


def run_script():
    '''
        기존 movies 데이터가 들어있는 파일을 읽어와서 moives 의 id 에 해당하는 trailer 데이터를 만듬
    '''
    with open(FOLDER_PACKAGE + INPUT_FILENAME, "r") as rf, open(FOLDER_PACKAGE + OUTPUT_FILENAME, "w",
                                                                newline="") as fw:
        rdr = csv.reader(rf)  # 데이터를 읽기
        writer = csv.writer(fw, delimiter=",")  # 데이터를 작성할곳
        writer.writerow(TMDB_TRAILER_TABLE_HEADER)  # csv 데이터헤더작성
        next(rdr)  # 첫줄 넘기기
        for line in rdr:
            movie_id, title, *_ = line
            writer.writerow([movie_id, DUMMY_OVERVIEW_TEXT + title, DUMMY_TRAILER_TITLE_TEXT + title,
                             (DUMMY_OVERVIEW_URL + movie_id).strip()])
        pass
    print('script done!')
    pass


if __name__ == "__main__":
    # todo-> tmdb trailer dummy data.csv
    run_script()
    pass
