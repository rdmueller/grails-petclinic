grails.servlet.version = "2.5"
grails.project.work.dir = "target/$grailsVersion"
grails.project.target.level = 1.6
grails.project.source.level = 1.6

grails.project.dependency.resolution = {

	inherits "global"
	log "error"
	checksums true

    def gebVersion = "0.9.3"
    //def seleniumVersion = "2.43.1"
    def seleniumVersion = "2.34.0"
    
	repositories {
		inherits true

		grailsPlugins()
		grailsHome()
		grailsCentral()

		mavenLocal()
		mavenCentral()
	}

	dependencies {

        //for functional testing
        test("org.seleniumhq.selenium:selenium-firefox-driver:$seleniumVersion")
        // You usually only need one of these, but this project uses both
        test "org.gebish:geb-spock:$gebVersion"
        test "org.gebish:geb-junit4:$gebVersion"
        test 'org.apache.httpcomponents:httpcore:4.3'
        test 'org.apache.httpcomponents:httpclient:4.3'        
        test "org.spockframework:spock-grails-support:0.7-groovy-2.0"
        // we need ghostdriver for phantomjs...
        test( "com.github.detro.ghostdriver:phantomjsdriver:1.1.0" ) {
            transitive = false
        }
        test ("org.seleniumhq.selenium:selenium-remote-driver:$seleniumVersion") // Needed by phantomjsdriver
    }
	plugins {
		runtime ":hibernate:$grailsVersion"
        runtime ":jquery:1.8.3"
        test ":geb:$gebVersion"        
        test ":film-strip:0.1.4"        
        
		runtime ":resources:1.1.6"
		build ":tomcat:$grailsVersion"
		runtime ":database-migration:1.1"
		compile ":cache:1.0.0"
	}
}
