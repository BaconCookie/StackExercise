SOURCE_FILES = $(filter-out src/list/package-info.java,$(wildcard src/**/*.java))
CLASS_FILES = $(SOURCE_FILES:src/%.java=out/%.class)

TEST_SOURCE_FILES = $(filter-out src/list/package-info.java,$(wildcard src/**/*Test.java))
TEST_CLASS_FILES = $(TEST_SOURCE_FILES:src/%.java=out/%.class)
TEST_CLASS_NAMES = $(subst /,.,$(TEST_CLASS_FILES:out/%.class=%))

EMPTY :=
SPACE := $(EMPTY) $(EMPTY)

LIBRARY_JARS = $(wildcard lib/*.jar) lib/Prog1Tools.zip
CLASSPATH = $(subst $(SPACE),:,$(LIBRARY_JARS:%=../%))

default: $(CLASS_FILES)

out/%.class: src/%.java
	mkdir -p out
	cd src && javac -classpath "$(CLASSPATH)" -sourcepath . -d ../out $(<:src/%=%)

run-app: default
	cd out && java programm/Main

run-test: $(CLASS_FILES) $(TEST_CLASS_FILES)
	cd out && java -classpath "$(CLASSPATH):." org.junit.runner.JUnitCore $(TEST_CLASS_NAMES)

doc:
	rm -rf doc
	cd src && javadoc **/*.java -d ../doc/

clean:
	rm -rf out doc

.PHONY: default run-app run-test doc clean

