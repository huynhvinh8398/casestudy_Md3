<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta content="A fully featured admin theme which can be used to build CRM, CMS, etc." name="description">
<meta content="Coderthemes" name="author">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- App favicon -->
<link rel="shortcut icon" href="/assets/images/favvicon.ico">

<!-- App css -->
<link href="/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="/assets/css/icons.min.css" rel="stylesheet" type="text/css">
<link href="/assets/css/app.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">

<!-- jquery-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" ></script>
<script>
    $(document).ready(function(){
        let listMMShow = document.querySelectorAll(".mm-active > .mm-show");
        listMMShow.forEach(item=>{
            item.classList.remove("mm-show");
        });
        let listMMActive = document.querySelectorAll(".mm-active");
        listMMActive.forEach(item=>{
            item.classList.remove("mm-active");
        });
    });
</script>