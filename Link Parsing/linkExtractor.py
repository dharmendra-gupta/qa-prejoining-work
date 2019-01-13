#for reading and extracting links from HTML page
from bs4 import BeautifulSoup
#for opening HTTP links
import requests
#importing lxml parser for fast parsing
import lxml
#importing sys for exiting
import sys

#getting url from user
url=input('Enter URL:')

#main code
try:
    #opening url
    html=requests.get(url,timeout=3)
    #making bs4 object for reading and parsing using lxml parser for speed
    html_soup=BeautifulSoup(html.text,'lxml')
    for links in html_soup.findAll('a'):
        link_title = links.getText()
        link = links.get('href')
        print(link_title+":"+link)
    
except requests.Timeout:
    print('connection timed out...')
    sys.exit()
except requests.ConnectionError:
    print('Some connection error occurred')
    sys.exit()