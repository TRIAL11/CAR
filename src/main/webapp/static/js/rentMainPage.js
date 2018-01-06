$(document).ready(function () {
    $("#buttonFind").click(function () {
        var searchText=$("#searchText").val();
        if(searchText!==""&&searchText.length<15)
        {
            window.open("/car/searchCar/" + searchText);
            $("#searchText").val("");
        }
        else
        {
            alert("请输入关键字或正确的信息");
            $("#searchText").val("");
        }
    })
})