let bookList = [
    {
        bookCode: "P0206001",
        bookTitle: "이것이자바다",
        bookAuthor: "홍성문",
        bookPress: "신흥출판사",
        bookPrice: "20000",
    },
    {
        bookCode: "P0206002",
        bookTitle: "이것이자바스크립트다",
        bookAuthor: "홍영웅",
        bookPress: "우리출판사",
        bookPrice: "25000",
    },
];

for (let i = 0; i < bookList.length; i++) {
    let innerbook = `<tr id =${i}>
      <td><input type="checkbox" name="chk[]"></td>
      <td>${bookList[i].bookCode}</td>
      <td>${bookList[i].bookTitle}</td>
      <td>${bookList[i].bookAuthor}</td>
      <td>${bookList[i].bookPress}</td>
      <td>${bookList[i].bookPrice}</td>
      <td><button>삭제</button></td>
    </tr>`
    list.innerHTML += innerbook
}


list.addEventListener("click", cvt)
function cvt(e) {
    let node = e.target;
    if (node.nodeName == "BUTTON") {
        node.closest("tr").remove();
    }
}

let cbx = document.querySelector("#title input[type='checkbox']");
cbx.addEventListener("click", function () {
    let selectAll = document.querySelectorAll("#list input[type='checkbox']");
    if (cbx.checked == true) {
        selectAll.forEach(item => {
            item.checked = true;
        });
    } else {
        selectAll.forEach(item => {
            item.checked = false;
        });
    }
});

cdl.addEventListener("click", function(){
	let selectAll = document.querySelectorAll("#list input[type='checkbox']");
	selectAll.forEach(item => {
		if(item.checked == true){
			item.closest("tr").remove();
		}
	});
})