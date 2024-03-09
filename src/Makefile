#Make file for Generics Knowledge Base programs
#Nancia Mwaramba
# 6 March 2024



JAVAC = javac
JFLAGS = -g
SOURCES = GenericsKbArrayApp.java

.SUFFIXES: .java .class
.java.class:
$(JAVAC) $(JFLAGS) $<

C.class: GenericsKbArrayApp.class

javadoc:
	javadoc -d 
clean:
@rm –f $(SOURCES:.java=.class)

