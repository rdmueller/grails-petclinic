package org.grails.samples

import org.grails.samples.pages.AddOwnerPage
import org.grails.samples.pages.ShowOwnerPage

class AddOwnerSpec extends PetclinicSpecs {
	
	def setup() {
		to AddOwnerPage
        report "add owner"
	}
	
	def 'can NOT add an invalid Owner'() {
		when:
		addOwner.click()
        report "all errors"
		then:
		at AddOwnerPage
		errors.size() == 5
	}
	
	def 'can add a valid Owner'() {
		given: "add owner form filled with a dummy owner"
		firstName.value 'Sally'
		lastName.value 'Jones'
		address.value '987 State St.'
		city.value 'MSN'
		telephone.value '1234567890'
		report "dummy owner"
        
		when: "click add owner button"
		addOwner.click()
		report "show owner"
        
		then: "owner is added and shown"
		at ShowOwnerPage
	}
}
