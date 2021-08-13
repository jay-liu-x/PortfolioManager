# Run `pip3 install requirements.txt` to get all the required Python packages
# Download MySql Service at

import requests
import json
import pandas as pd
import time as t
import pyodbc
import random

symbols = ["MSFT", "AMZN", "AAPL", "TSLA", "GOOG", "FB",
           "WMT", "BAC", "ADBE", "NKE", "HD", "BABA", "DIS", "PFE"]

url = "https://alpha-vantage.p.rapidapi.com/query"

headers = {
    'x-rapidapi-key': "230944fce1msh6254527316a6fdap1eee56jsnaa360d722084",
    'x-rapidapi-host': "alpha-vantage.p.rapidapi.com"
}

result = {}

for symbol in symbols:
    print('Fetching data for:', symbol)
    querystring = {"function": "TIME_SERIES_DAILY",
                   "symbol": symbol, "outputsize": "compact", "datatype": "json"}

    response = requests.request(
        "GET", url, headers=headers, params=querystring)
    data = json.loads(response.text)['Time Series (Daily)']

    # get close price
    for time, prices in data.items():
        data[time] = [float(value) for price_type, value in prices.items() if price_type == "4. close"][0]

    result[symbol] = data

    print('Sleeping for 12 secs...')
    t.sleep(12)

# save to database
PASSWORD = 'password'  # change it based on your system
cnxn = pyodbc.connect(
    "DRIVER={ODBC Driver 17 for SQL Server};SERVER=localhost;DATABASE=testdb;UID=me;PWD=" + PASSWORD)

cursor = cnxn.cursor()

cursor.execute("""
               INSERT INTO investments(symbol, purchase_price, purchase_time, close_price, date, quantity)
               VALUES(?,?,?,?,?,?)
               """, '')
