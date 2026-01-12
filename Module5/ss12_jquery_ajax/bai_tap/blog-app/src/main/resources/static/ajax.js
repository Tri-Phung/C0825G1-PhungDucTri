let currentPage = 0;
let currentKeyword = "";
$(document).ready(function() {
    loadBlogs(currentKeyword, currentPage, false);
    $("#btnSearch").click(function() {
        currentKeyword = $("#keyword").val();
        currentPage = 0;
        loadBlogs(currentKeyword, currentPage, false);
    });
    $("#btnLoadMore").click(function() {
        currentPage++;
        loadBlogs(currentKeyword, currentPage, true);
    });
});
function loadBlogs(keyword, page, isAppend){
    $.ajax({
        url: "/api/blogs/search",
        type: "GET",
        data: {
            keyword: keyword,
            page: page,
            size: 5
        },
        success: function(response){
            let blogs = response.content;
            let tbody = document.getElementById("blogList");
            if (!isAppend) {
                tbody.innerHTML = "";
            }
            if (blogs.length === 0 && !isAppend) {
                let row = tbody.insertRow(-1);
                let cell = row.insertCell(0);
                cell.colSpan = 4;
                cell.style.textAlign = "center";
                cell.textContent = "Không tìm thấy bài viết nào phù hợp.";
            }
            blogs.forEach(blog => {
                let row = tbody.insertRow(-1);
                let cellId = row.insertCell(0);
                let cellTitle = row.insertCell(1);
                let cellSummary = row.insertCell(2);
                let cellAuthor = row.insertCell(3);
                cellId.textContent = blog.id;
                cellTitle.textContent = blog.title;
                cellAuthor.textContent = blog.author;
                cellSummary.textContent = blog.summary;
            });
            if (response.last) {
                $("#btnLoadMore").hide();
            } else {
                $("#btnLoadMore").show();
            }
        }
    })
}