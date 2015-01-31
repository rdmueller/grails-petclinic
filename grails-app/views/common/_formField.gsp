${label}: <span class="errors"><g:fieldError bean="${bean}" field="${field}" /></span>
<br/>
<g:textField id="${name + '_' +field}" name="${name + '.' +field}" value="${fieldValue(bean:bean, field:field)}" />
