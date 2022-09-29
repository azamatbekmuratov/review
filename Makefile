
build-run:
	mvn clean install -Dmaven.test.skip
	docker-compose up -d

test:
	mvn test