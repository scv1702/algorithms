def date_to_day(date):
    return date[2] + date[1] * 28 + date[0] * 28 * 12

def solution(today, terms, privacies):
    answer = []
    today = date_to_day(list(map(int, today.split('.'))))
    terms = { t.split()[0]: int(t.split()[1]) for t in terms }
    for idx, privacy in enumerate(privacies):
        date, term = privacy.split()
        date = date_to_day(list(map(int, date.split('.'))))
        expiration = date + terms[term] * 28 - 1
        if expiration < today:
            answer.append(idx + 1)
    return answer
