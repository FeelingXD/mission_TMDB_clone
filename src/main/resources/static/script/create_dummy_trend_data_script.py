import csv,random
'''
    TMDB DB TREND 테이블의 더미 데이터를 만들기 위한 스크립트입니다.
'''
PLATFORM_TYPE=["TV","STREAMING","RENTAL","THEATER"]

FOLDER_PACKAGE="./csv_data/"
INPUT_FILENAME="movies_example_modified.csv"
OUTPUT_FILENAME="TMDB_PLATFORM_TYPE_DUMMY_DATA.csv"
TMDB_PLATFORM_TABLE_HEADER=["movie_id","platform"] # 복합키 
def run_script():
    '''
        기존 movies 데이터가 들어있는 파일을 읽어와서 moives 의 id 에 해당하는 플랫폼 타입을 만듬
    '''
    with open(FOLDER_PACKAGE+INPUT_FILENAME,"r") as rf,open(FOLDER_PACKAGE+OUTPUT_FILENAME,"w",newline="") as fw:
        rdr=csv.reader(rf) # 데이터를 읽기
        writer= csv.writer(fw,delimiter=",") # 데이터를 작성할곳
        writer.writerow(TMDB_PLATFORM_TABLE_HEADER) # csv 데이터헤더작성
        
        next(rdr) #첫줄 넘기기
        for line in rdr:
            movie_id,*_=line
            for type in set(random.choices(PLATFORM_TYPE,k=len(PLATFORM_TYPE))):
                writer.writerow([movie_id,type.strip()])

    print('script done!')
    pass

if __name__=="__main__":
    # todo -> tmdb platfrom table dummy data.csv
    run_script()