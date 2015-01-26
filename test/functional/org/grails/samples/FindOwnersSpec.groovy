package org.grails.samples

import org.grails.samples.pages.AddOwnerPage
import org.grails.samples.pages.FindOwnersPage
import org.grails.samples.pages.OwnerSelectionPage
import org.grails.samples.pages.ShowOwnerPage

class FindOwnersSpec extends PetclinicSpecs {

	def setup() {
		to FindOwnersPage
        report "FindOwnersPage"
	}
	
	def 'can add a new Owner'() {
		expect:
		addOwner.click()
        report "AddOwnerPage"
		at AddOwnerPage
	}
	
	def 'can NOT find the specified Owners'() {
		given:
		lastName.value ''
		
		when:
		findOwners.click()
		report "no owners found"
		then:
		at FindOwnersPage
		error
	}
	 
	def 'can find one specified Owner'() {
		given:
		lastName.value 'Bubinga'
		report "form filled"
		when:
		findOwners.click()
		report "owner found"
		then:
		at ShowOwnerPage 
	}
	 
	def 'can find multiple specified Owners'() {
		given:
		lastName.value 'Smith'
		report "form filled"
		when:
		findOwners.click()
		report "owners found"
		then:
		at OwnerSelectionPage
	}
 
}
