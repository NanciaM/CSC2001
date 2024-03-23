# AVL program makefile
# Nancia Mwaramba
# 22 March 2024

JAVAC=/usr/bin/javac
JFLAGS = -g
JC=javac
SRCDIR= src
DOCDIR = doc
BINDIR = bin

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) -cp $(BINDIR ) $*.java -d $(BINDIR)

classes: KnowledgeEntry.class AVLTreeNode.class AVLTree.class \
	GenericsKbAVLApp.class
  

default: $(CLASSES)

clean:
	rm $(BINDIR)/*.class

run:
	java -cp $(BINDIR)

javadoc:
	javadoc -d $(DOCDIR) $(SRCDIR)/*.java

docs:
	javadoc -d doc/ src/*.java

