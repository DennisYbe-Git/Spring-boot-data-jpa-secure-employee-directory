'use strict';

console.log("HELLO");
// event delegation on table to the Delete button
/*
const deleteBtn = document.querySelector('.table');
deleteBtn.addEventListener('click', function(ev) {
	
	console.log("THERE");
	const target = ev.target;
	console.log(target.textContent);
	
	if (target.textContent !== deleteLabel) {
		return;
	}
	
	const ok = window.confirm(confirmMsg);
	if (!ok)
		ev.preventDefault();
		
	
});
*/

// onclick used in the html to call this function
const confirmDelete = function(ev, user) {
	
	const ok = window.confirm(confirmMsg+user);
	if (!ok)
		ev.preventDefault();
	
}
