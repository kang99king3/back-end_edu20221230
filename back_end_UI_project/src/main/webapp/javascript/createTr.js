function createTr(inputs){
	var tr=document.createElement("tr");//tr 1개
	
	for (var i = 0; i < inputs.length; i++) {
		var td=document.createElement("td");//td 4개
		td.textContent=inputs[i].value;//<td>입력값</td>
		tr.appendChild(td);//<tr><td>입력값</td>...</tr>
	}
	return tr;
}