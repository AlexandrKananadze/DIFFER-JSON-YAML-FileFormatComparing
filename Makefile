setup:
	./gradlew wrapper --gradle-version 6.8.3

clean:
	./gradlew clean

build: clean
	./gradlew build

install: clean
	./gradlew install

run-dist:
	./build/install/app/bin/app

run:
	./gradlew run

test:
	./gradlew test

lint:
	./gradlew checkstyleMain checkstyleTest

check-updates:
	./gradlew dependencyUpdates

reports:
	./gradlew test
	./gradlew jacocoTestReport

build-run: build run