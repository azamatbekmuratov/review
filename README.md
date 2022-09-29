# Review Service

Review service. Fetches review of product by product id. Uses caching mechanism in GET methods


## Requirements

1. Docker and docker compose installed
2. Maven is installed
3. Make is installed (Can do without Makefile)
4. Java 11 is installed


## How to run using Makefile

### Build and Run in docker
1. Set in hosts.sh your IP address instead of 192.168.0.103. Used for database and Redis connection. Then run the script
2. Type in terminal make build-run
3. Need to create manually the database inside postgres docker container. Did not write bash script for that. CREATE DATABASE review_db;

## How to run tests using Makefile

1. Redis has to be configured from given docker-compose file
2. Type in terminal make test


## How to use it
### Review for products
ID of products which have review M20324, AC7836, BB5476. It is possible to create by yourself by calling POST method. If reviews is not found, it will return HTTP status code 404 with appropriate message

<p align="center">
  <img src="https://snipboard.io/NnvgdO.jpg" alt="Size Limit CLI" width="738">
</p>