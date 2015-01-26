package org.grails.samples

import geb.spock.GebReportingSpec

import org.grails.samples.pages.WelcomePage

abstract class PetclinicSpecs extends GebReportingSpec {
	
	def 'can go Home'() {
		when:
		home.click()
        report "home"
        
		then:
		at WelcomePage
	}
}
