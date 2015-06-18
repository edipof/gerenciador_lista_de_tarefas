BIN = TP2.jar
JCR = java

#Argumentos de entrada
ARGS = ""


all:
	find -name "*.java" > sources.txt
	javac @sources.txt
	find -name "*.class" > class.txt
	jar cfm $(BIN) ./META-INF/MANIFEST.MF @class.txt

clean:
	for x in `find -name "*.class"`; do rm -f $$x; done
	rm -f sources.txt
	rm -f class.txt

#run :
#	$(JCR) br/ufmg/dcc/Main $(ARGS)

run:
	$(JCR) -jar $(BIN) $(ARGS)