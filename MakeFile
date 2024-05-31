all: build run

build:
	javac -Xlint:all -Xlint:-serial -Xlint:-this-escape *.java

run:
	java Adventure

clean:
	rm -f *.class
	rm -f *~
