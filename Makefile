# Generic Knowledge base program makefile
# Nancia Mwaramba
# 6 March 2024
GenericsKbArrayApp
JAVAC=/usr/bin/javac

.SUFFIXES: .java .class

.java.class:
	$(JAVAC) $<

classes: GenericsKbArrayApp.class



default: $(CLASSES)

clean:
	rm *.class

