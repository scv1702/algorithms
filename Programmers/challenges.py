import requests
import random

url = "https://school.programmers.co.kr/api/v2/school/challenges/"

def get_query_str(level, page):
    return f"?perPage=30&levels[]={level}&languages[]=java&order=acceptance_asc&search=&page={page}"

def get_challenges(level):
    query_str = get_query_str(level, 1)
    response = requests.get(url + query_str)
    total_pages = response.json()["totalPages"]
    res = []
    for page in range(1, total_pages + 1):
        query_str = get_query_str(level, page)
        response = requests.get(url + query_str)
        result = response.json()["result"]
        res.extend(result)
    return res

challenges = []
challenges.extend(get_challenges(2))
challenges.extend(get_challenges(3))

random_challenge = random.choice(challenges)

id = random_challenge["id"]
title = random_challenge["title"]
level = random_challenge["level"]

print(f"Challenge ID: {id}")
print(f"Challenge Title: {title}")
print(f"Challenge Level: {level}")
print(f"Challenge URL: https://school.programmers.co.kr/learn/courses/30/lessons/{id}")