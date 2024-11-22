<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sách tòa nhà</title>

</head>

<body>
<style>
    /* Thêm CSS nếu cần */
    .search .container-fluid .row {
        display: flex;
        align-items: center;
    }

    .search .container-fluid .row .col-md-8,
    .search .container-fluid .row .col-md-4,
    .search .container-fluid .row .col-md-3,
    .search .container-fluid .row .col-md-5 {
        display: flex;
        flex-direction: column;
    }


</style>
<style>
    .container {
        margin-top: 100px;
    }

    .table thead th {
        background-color: #d3d3d3;
    }

    .action-btn {
        font-size: 1.2rem;
        cursor: pointer;
        margin-right: 5px;
    }

    .action-btn-green {
        color: #28a745;
    }

    .action-btn-blue {
        color: #007bff;
    }

    .action-btn-red {
        color: #dc3545;
    }

</style>

<style>
    /* CSS cho modal */
    .modal {
        display: none; /* Ẩn modal mặc định */
        position: fixed;
        z-index: 1;
        left: 0;
        top: 0;
        width: 100%;
        height: 100%;
        background-color: rgba(0, 0, 0, 0.5); /* Nền mờ */
        overflow: auto;
        padding-top: 60px;
    }

    .modal-content {
        background-color: white;
        margin: 5% auto;
        padding: 20px;
        border: 1px solid #888;
        width: 80%;
    }

    /* Nút đóng modal */
    .close-btn {
        color: #aaa;
        float: right;
        font-size: 28px;
        font-weight: bold;
    }

    .close-btn:hover,
    .close-btn:focus {
        color: black;
        text-decoration: none;
        cursor: pointer;
    }

    table {
        width: 100%;
        border-collapse: collapse;
    }

    table, th, td {
        border: 1px solid black;
    }

    th, td {
        padding: 8px;
        text-align: left;
    }
</style>
<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <i class="ace-icon fa fa-home home-icon"></i>
        <li class="breadcrumb-item"><a href="./home">Trang chủ</a></li>
        <li class="breadcrumb-item active" aria-current="page">Danh sách tòa nhà</li>
    </ol>
</nav>

<div class="search">
    <form:form id="formlist" modelAttribute="buildingSearchRequest" action="/admin/building-list" method="get">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-8">
                    <label for="buildingName">Tên tòa nhà</label>
                    <input type="text" id="buildingName" name="name" value="${buildingSearchRequest.name}"/>
                </div>
                <div class="col-md-4">
                    <label for="floorArea">Diện tích sàn</label>
                    <input type="text" id="floorArea" name="floorArea" value="${buildingSearchRequest.floorArea}"/>
                </div>
            </div>
            <div class="row">
                <div class="col-md-3">
                    <label for="district">Quận</label>
                    <form:select id="district" name="district" path="district">
                        <form:option value="">---Chọn quận---</form:option>
                        <form:options items="${districtCode}"/>
                    </form:select>
                </div>
                <div class="col-md-5">
                    <label for="ward">Phường</label>
                    <input type="text" id="ward" name="ward" value="${buildingSearchRequest.ward}"/>
                </div>
                <div class="col-md-4">
                    <label for="sreet">Đường</label>
                    <input type="text" id="sreet" name="street" value="${buildingSearchRequest.street}"/>
                </div>
            </div>
            <div class="row">
                <div class="col-md-3">
                    <label for="numberOfBasement">Số tầng hầm</label>
                    <input type="number" id="numberOfBasement" name="numberOfBasement"
                           value="${buildingSearchRequest.numberOfBasement}"/>
                </div>
                <div class="col-md-5">
                    <label for="direction">Hướng</label>
                    <input type="text" id="direction" name="direction" value="${buildingSearchRequest.direction}"/>
                </div>
                <div class="col-md-4">
                    <label for="level">Hạng</label>
                    <input type="text" id="level" name="level" value="${buildingSearchRequest.level}"/>
                </div>
            </div>
            <div class="row">
                <div class="col-md-3">
                    <label for="areaFrom">Diện tích từ</label>
                    <input type="number" id="areaFrom" name="areaFrom" value="${buildingSearchRequest.areaFrom}"/>
                </div>
                <div class="col-md-3">
                    <label for="areaTo">Diện tích đến</label>
                    <input type="text" id="areaTo" name="areaTo" value="${buildingSearchRequest.areaTo}"/>
                </div>
                <div class="col-md-3">
                    <label for="rentPriceFrom">Giá thuê từ</label>
                    <input type="text" id="rentPriceFrom" name="rentPriceFrom"
                           value="${buildingSearchRequest.rentPriceFrom}"/>
                </div>
                <div class="col-md-3">
                    <label for="rentPriceTo">Giá thuê đến</label>
                    <input type="text" id="rentPriceTo" name="rentPriceTo"
                           value="${buildingSearchRequest.rentPriceTo}"/>
                </div>
            </div>

            <div class="row">
                <div class="col-md-3">
                    <label for="staff">Nhân Viên</label>
                    <form:select id="staff" name="staffId" path="staffId">
                        <form:option value="">---Chọn nhân viên---</form:option>
                        <form:options items="${listStaffs}"/>
                    </form:select>
                </div>
                <div class="col-md-5">
                    <label for="managerName">Tên quản lý</label>
                    <input type="text" id="managerName" name="managerName"
                           value="${buildingSearchRequest.managerName}"/>
                </div>
                <div class="col-md-4">
                    <label for="managerPhone">Số điện thoại quản lý</label>
                    <input type="text" id="managerPhone" name="managerPhone"
                           value="${buildingSearchRequest.managerPhone}"/>
                </div>
            </div>
            <div class="row">
                <form:checkboxes items="${typeCode}" path="typeCode"/>
            </div>
            <form:button type="submit">Tìm kiếm</form:button>
        </div>
    </form:form>
</div>
<div id="addBuildingOrDeleteBuilding" style="margin-top: 10px">
    <button type="button" id="addBuilding">Thêm toà nhà</button>
    <button type="button" id="deleteAllBuilding">Xóa tòa nhà</button>
</div>
<div class="container my-4">
    <table class="table table-bordered">
        <thead>
        <tr>
            <th scope="col">
                <input type="checkbox" id="selectParent">
            </th>
            <th scope="col">Tên tòa nhà</th>
            <th scope="col">Địa chỉ</th>
            <th scope="col">Số tầng hầm</th>
            <th scope="col">Tên quản lý</th>
            <th scope="col">Số điện thoại quản lý</th>
            <th scope="col">Giá thuê</th>
            <th scope="col">D.Tích sàn</th>
            <th scope="col">D.Tích trống</th>
            <th scope="col">D.Tích thuê</th>
            <th scope="col">Phí dịch vụ</th>
            <th scope="col">Phí môi giới</th>
            <th scope="col">Thao tác</th>
        </tr>
        </thead>
        <tbody id="resultSearchBuilding">
        <c:forEach var="item" items="${buildingSearchResponses}">
            <tr>
                <td><input type="checkbox" value="${item.id} " class="selectChildren"></td>
                <td class="nameBuilding">${item.name}</td>
                <td>${item.address}</td>
                <td>${item.numberOfBasement}</td>
                <td>${item.managerName}</td>
                <td>${item.managerPhone}</td>
                <td>${item.rentPrice}</td>
                <td>${item.floorArea}</td>
                <td>${item.emptyArea}</td>
                <td>${item.rentArea}</td>
                <td>${item.serviceFee}</td>
                <td>${item.brokerageFee}</td>
                <td>
                    <button class="assignmentBuilding">&#128196;</button>
                    <button class="editBuilding">&#9998;</button>
                    <button class="deleteBuilding">&#128465;</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<!-- Modal chứa bảng -->
<div id="myModal" class="modal">
    <div class="modal-content">
        <span class="close-btn" id="closeModalBtn">&times;</span>
        <h2>Bảng Thông Tin Tòa Nhà</h2>
        <table>
            <thead>
            <tr>
                <th>Chọn</th>
                <th>Tên nhân viên</th>
            </tr>
            </thead>
            <tbody id="addstaff">

            </tbody>
        </table>
        <button>
            Giao tòa nhà
        </button>
    </div>
    <div>
    </div>
</div>


<script>

    document.querySelector("#addBuilding").addEventListener('click', function (evt) {
        location.href = "/admin/building-edit";
    })

    document.querySelector("#deleteAllBuilding").addEventListener('click', function (evt) {
        let checkboxes = document.querySelectorAll('.selectChildren:checked');
        let listID = [];
        checkboxes.forEach(function (checkbox) {
            listID.push(checkbox.value);
        });
        if (listID.length === 0) {
            alert("Hãy chọn tòa nhà để xóa");
            return;
        }
        let urlTarget = "/api/building/" + listID.toString();
        fetch(urlTarget, {
            method: "Delete"
        }).then(response => {
            if (response.ok) {
                window.alert("Xóa tòa nhà thành công");
            } else {
                window.alert("Xóa tòa nhà thành công");
            }
        }).catch(error => {
            console.log("Lỗi xóa tòa nhà" + error)
            alert("Không thể xóa tòa nhà");
        })
    })


    document.querySelector("#selectParent").addEventListener('change', function (evt) {
        let checkboxes = document.querySelectorAll('.selectChildren');
        checkboxes.forEach(function (checkbox) {
            checkbox.checked = evt.target.checked;
        });
    });

    document.querySelector("tbody#resultSearchBuilding").addEventListener('click', function (evt) {
        if (evt.target.classList.contains("editBuilding")) {
            const row = evt.target.closest("tr");
            const buildingId = row.querySelector(".selectChildren").value;
            window.location.href = "/admin/building-edit/" + buildingId;
        } else if (evt.target.classList.contains("deleteBuilding")) {
            const row = evt.target.closest("tr");
            const isDeleteBuilding = confirm("Bạn có chắc chắn muốn xóa tòa nhà: " + row.querySelector(".nameBuilding").textContent);
            if (isDeleteBuilding) {
                alert("Bạn đã xác nhận xóa tòa nhà");
            } else {
                return;
            }
            let buildingId = row.querySelector(".selectChildren").value;
            let urlTarget = "/api/Building/" + buildingId;
            fetch(urlTarget, {
                method: "Delete"
            }).then(response => {
                if (response.ok) {
                    window.alert("Xóa tòa nhà thành công");
                } else {
                    window.alert("Xóa tòa nhà thành công");
                }
            }).catch(error => {
                console.log("Lỗi xóa tòa nhà" + error)
                alert("Không thể xóa tòa nhà");
            })

        } else if (evt.target.classList.contains("assignmentBuilding")) {
            const row = evt.target.closest("tr");
            const buildingId = row.querySelector(".selectChildren").value;
            let urlTarget = "/api/building/" + buildingId;
            fetch(urlTarget)
                .then(response => {
                    if (response.ok) {
                        return response.json();
                    } else {
                        console.error("API không thành công:", response.statusText);
                        return null;
                    }
                })
                .then(result => {
                    if (result) {
                        let htmls = "";
                        console.log(result);
                        result.forEach(item => {
                            htmls += '<tr>';

                            // Cột checkbox
                            if (item.data.checked) {
                                htmls += '<td><input type="checkbox" checked /></td>';
                            } else {
                                htmls += '<td><input type="checkbox" /></td>';
                            }
                            // Cột fullName
                            htmls += '<td>' + item.data.fullName + '<td>';

                            htmls += '</tr>';
                        });
                        document.getElementById("addstaff").innerHTML = htmls;
                    } else {
                        console.warn("Không có dữ liệu trả về từ API.");
                    }
                })
                .catch(error => {
                    console.error("Lỗi khi fetch dữ liệu:", error);
                });

            // Lấy các phần tử cần thiết
            const modal = document.getElementById("myModal");
            const closeModalBtn = document.getElementById("closeModalBtn");
            // Khi người dùng nhấn vào nút "Hiển thị bảng", mở modal
            modal.style.display = "block";
            // Khi người dùng nhấn vào nút "Đóng", đóng modal
            closeModalBtn.onclick = function () {
                modal.style.display = "none";
            }
            // Nếu người dùng nhấp ngoài modal, đóng modal
            window.onclick = function (event) {
                if (event.target === modal) {
                    modal.style.display = "none";
                }
            }
        }
    })
</script>
</body>
</html>
