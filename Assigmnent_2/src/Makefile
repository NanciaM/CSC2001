# AVL program makefile
# Nancia Mwaramba
# 22 March 2024

JAVAC=/usr/bin/javac

.SUFFIXES: .java .class

.java.class:
	$(JFLAGS) $<

classes: KnowledgeEntry.class AVLTreeNode.class \
       	AVLTree.class GenericsKbAVLApp.class
  

default: $(CLASSES)

clean:
	rm *.class

