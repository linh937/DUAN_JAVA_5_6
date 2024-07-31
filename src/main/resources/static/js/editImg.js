const fileform = document.querySelector(".fileform")
const customFile = document.querySelector("#customFile")
const imgProduct = document.querySelector("#imgProduct")
const deleteFile = document.querySelector("#deleteFile")
const Filename = document.querySelector("#Filename")

function defautlBtnIMG() {
    fileform.click();
}

fileform.addEventListener("change", function() {
    const file = this.files[0];
    if (file) {
        const render = new FileReader();
        render.onload = function() {
            const result = render.result;
            imgProduct.src = result;
        }

        deleteFile.addEventListener("click", function() {
            imgProduct.src = "";
            Filename.value = "";
        })
		
		
        render.readAsDataURL(file);
    }
    
    if(this.value){
		let vl = this.value.match("/[0-9a-zA-Z]\^\&\'\@\{\}\[\]\,\$\=\!\-\#\(\)\.\%\+\~\_]+$/")
		Filename.value = vl
	}

})
