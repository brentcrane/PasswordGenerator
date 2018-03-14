#
# My make file, which is hard to get working on Windows, so I
# will have to test it later with Linux.
#
# Saves me from having to recompile my code every time I want
# to run it.
#

JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
        $(JC) $(JFLAGS) $*.java

CLASSES = \
        PasswordGenerator.java \
        AccountInfo.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
        $(RM) *.class