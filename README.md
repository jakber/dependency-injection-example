#Dependency Injection Workshop Example

To run it you need to point the DB class at ratings.list.gz from IMDB (see "plain text data files" at http://www.imdb.com/interfaces).

The following is the script I used during the presentation:

Intro: Q&A

MovieApp - walkthrough

##MovieApp
- MovieListService
		- MovieResource
			- DB
		- ScoreResource
			- DB
	- Healthcheck
		- MovieResource
			- DB
		- ScoreResource
			- DB


Duplication: many DB objects, only one needed -> Constructor, factory or service locator

Tests for MovieListService: how to mock

Dependency injection to the rescue

Complex initialization: DI container to the rescue

Introducing Guice & JSR-330

Injectors and Modules

 - bindings
 - provider methods
 - no lifecycle management!
 - no magic!
 - @Named and annotatedWith
 - TypeLiteral

Default constructor and @Inject

Constructor vs Field injection

Scopes

When to inject Provider<T>

Servlet integration:
 - GuiceServletContextListener
 - ServletModule: web.xml replacement


Extensions

 - AssistedInject
 - Multibinder
 - TypeListeners/AOP