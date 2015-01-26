package org.grails.samples

import org.grails.samples.pages.DisplayVetsPage
import org.grails.samples.pages.FindOwnersPage
import org.grails.samples.pages.TutorialPage
import org.grails.samples.pages.WelcomePage

class WelcomeSpec extends PetclinicSpecs {
	
	def setup() {
		to WelcomePage
        report "Welcome Page"
	}
	
	def 'can find an Owner'() {
		expect:
		at WelcomePage
		findOwner.click()
        report "Find Owners Page"
		at FindOwnersPage
	}
	
	def 'can display all Veterinarians'() {
		expect:
		at WelcomePage
		displayAllVets.click()
        report "DisplayVetsPage"
		at DisplayVetsPage
	}

	def 'can display a Tutorial'() {
		expect:
		at WelcomePage
		tutorial.click()
        report "TutorialPage"
		at TutorialPage
	}
}
