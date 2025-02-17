##
# Project Title
#
# @file
# @version 0.1


run: all
	java src/recipeBookApplication/Main.java

all: GNUmakefile
	make -j24 bin/recipeBookApplication/*.class

src/recipeBookApplication/%.class: src/recipeBookApplication/%.java GNUmakefile
	javac $<

# bin/recipeBookApplication/RecipesManagement.class: bin/recipeBookApplication/Recipes.class src/recipeBookApplication/RecipesManagement.java makefile
# 	javac $@

# bin/recipeBookApplication/Recipes.class: src/recipeBookApplication/Recipes.java makefile
# 	javac $@


# end
