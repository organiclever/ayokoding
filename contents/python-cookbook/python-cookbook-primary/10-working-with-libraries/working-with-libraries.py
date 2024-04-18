import requests
# to enable the requests library, you need to install it first
# use the command: pip install requests
# or using this file: requirements.txt => run the command: pip install -r requirements.txt

# Make a GET request to a URL
response = requests.get("https://swapi.dev/api/people")

# Check the response status code
if response.status_code == 200:
    # Successful response
    data = response.json()  # Parse the response data as JSON
    print(data['results'][0])
else:
    # Error handling for failed request
    print("Error", response.status_code)
