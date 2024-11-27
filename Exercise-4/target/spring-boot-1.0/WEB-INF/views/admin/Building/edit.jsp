<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<html>
<head>
    <title>Title</title>
    <style>
        /* Thêm CSS toàn cục */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: Arial, sans-serif;
            min-height: 100vh;
            display: flex;
            flex-direction: column;
        }

        .search .container-fluid .row {
            display: flex;
            align-items: center;
            width: 100%;
        }

        .search .container-fluid .row .col-md-8,
        .search .container-fluid .row .col-md-4,
        .search .container-fluid .row .col-md-3,
        .search .container-fluid .row .col-md-5 {
            display: flex;
            flex-direction: column;
            width: 100%;
        }

        .container {
            margin-top: 50px;
            width: 100%;
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

        /* Breadcrumb styles */
        .breadcrumb {
            background-color: transparent;
        }

        .breadcrumb-item {
            display: inline;
        }

        .breadcrumb-item a {
            color: #007bff;
            text-decoration: none;
        }

        .breadcrumb-item a:hover {
            text-decoration: underline;
        }

        /* Thêm khoảng cách hợp lý cho các form input */
        .search .container-fluid .row label {
            margin-bottom: 8px;
        }

        .search .container-fluid .row input,
        .search .container-fluid .row select {
            padding: 10px;
            font-size: 1rem;
            border: 1px solid #ccc;
            border-radius: 4px;
            width: 100%;
        }

        /* Link style */
        a {
            text-decoration: none;
            color: #007bff;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <i class="ace-icon fa fa-home home-icon"></i>
        <li class="breadcrumb-item"><a href="./home">Trang chủ</a></li>
        <li class="breadcrumb-item active" aria-current="page">Danh sách tòa nhà</li>
    </ol>
</nav>

<div class="search">
    <div class="container-fluid">
        <form:form modelAttribute="buildingEditRequestDTO" id="form-edit">
        <div class="row">
            <div class="col-md-12">
                <label for="buildingName">Tên tòa nhà</label>
                <form:input type="text" id="buildingName" name="buildingName" path="productName"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <label for="district">Quận</label>
                <form:select id="district" name="districtId" path="district">
                    <form:option value="">---Chọn quận---</form:option>
                    <form:options items="${districtCode}"/>
                </form:select>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <label for="ward">Phường</label>
                <form:input type="text" id="ward" name="ward" path="ward"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <label for="street">Đường</label>
                <form:input type="text" id="street" name="street" path="street"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <label for="structure">Kết cấu</label>
                <form:input type="text" id="structure" name="structure" path="structure"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <label for="numberOfBasement">Số tầng hầm</label>
                <form:input type="text" id="numberOfBasement" name="numberOfBasement" path="numberOfBasement"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <label for="floorArea">Diện tích sàn</label>
                <form:input type="text" id="floorArea" name="floorArea" path="floorArea"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <label for="direction">Hướng</label>
                <form:input type="text" id="direction" name="direction" path="direction"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <label for="level">Hạng</label>
                <form:input type="text" id="level" name="level" path="level"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <label for="rentArea"> Diện tích thuê </label>
                <form:input type="text" id="rentArea" name="rentArea" path="rentArea"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <label for="rentPrice">Giá thuê</label>
                <form:input type="text" id="rentPrice" name="rentPrice" path="rentPrice"/>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12">
                <label for="rentPriceDescription">Mô tả giá</label>
                <form:input type="text" id="rentPriceDescription" name="rentPriceDescription"
                            path="rentPriceDescription"/>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12">
                <label for="serviceFee">Phí dịch vụ</label>
                <form:input type="text" id="serviceFee" name="serviceFee"
                            path="serviceFee"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <label for="carFee">phí ô tô </label>
                <form:input type="text" id="carFee" name="carFee"
                            path="carFee"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <label for="motorBikeFee">phí mô tô </label>
                <form:input type="text" id="motorBikeFee" name="motorBikeFee"
                            path="motorBikeFee"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <label for="overTimeFee">phí ngoài giờ</label>
                <form:input type="text" id="overTimeFee" name="overTimeFee"
                            path="overTimeFee"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <label for="electricityFee">Tiền điện</label>
                <form:input type="text" id="electricityFee" name="electricityFee"
                            path="electricityFee"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <label for="deposit">Đặt cọc</label>
                <form:input type="text" id="deposit" name="deposit"
                            path="deposit"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <label for="payment">Thanh toán </label>
                <form:input type="text" id="payment" name="payment"
                            path="payment"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <label for="rentTime"> Thời hạn thuê </label>
                <form:input type="text" id="rentTime" name="rentTime"
                            path="rentTime"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <label for="decorationTime"> Thời gian trang trí </label>
                <form:input type="text" id="decorationTime" name="decorationTime"
                            path="decorationTime"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <label for="nameManager"> Tên quản lý </label>
                <form:input type="text" id="nameManager" name="nameManager"
                            path="nameManager"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <label for="phoneManager"> Số điện thoại quản lý </label>
                <form:input type="text" id="phoneManager" name="phoneManager"
                            path="phoneManager"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <label for="brokerageFee"> Phí môi giới </label>
                <form:input type="text" id="brokerageFee" name="brokerageFee"
                            path="brokerageFee"/>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12">
                <label class="form-label">Loại toà nhà</label>
                <form:checkboxes items="${typeCode}" path="type"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <label for="note"> Ghi chú </label>
                <form:input type="text" id="note" name="note"
                            path="note"/>
            </div>
        </div>

        <form:hidden path="id" id="buildingId"/>
    </div>
    </form:form>
</div>

<div>
    <c:if test="${ empty buildingEditRequest.id}">
        <button id="addBuilding" type="button">
            Thêm tòa nhà
        </button>
    </c:if>
    <c:if test="${ not empty buildingEditRequest.id }">
        <button id="updateBuilding" type="button">
            Cập nhật tòa nhà
        </button>
    </c:if>
    <button id="cancelEditBuilding" type="button">
        Hủy Thao Tác
    </button>
</div>
<script>
    const updateButton = document.querySelector("#updateBuilding");
    if (updateButton) {
        updateButton.addEventListener('click', function (evt) {
            evt.preventDefault(); // Ngăn trang reload
            const data = transformData();
            fetchAPI("/api/building/", data);
        });
    }

    const addButton = document.querySelector("#addBuilding");
    if (addButton) {
        addButton.addEventListener('click', function (evt) {
            evt.preventDefault(); // Ngăn trang reload
            const data = transformData();
            if (isValidData(data)) {
                console.log(data)
                fetchAPI("/api/building/", data);
            }
        });
    }

    const cancelEditBuilding = document.querySelector("#cancelEditBuilding");
    if (cancelEditBuilding) {
        cancelEditBuilding.addEventListener('click', function (evt) {
            evt.preventDefault();
            window.location.href = "/admin/building-list"
        })
    }


    function transformData() {
        let data = {};
        let type = [];
        let rentArea = [];
        const dataFrom = new FormData(document.getElementById("form-edit"));

        dataFrom.forEach(function (value, key) {
            if (key === 'type') {
                type.push(value);
            } else if (key === 'rentArea') {

                rentArea = value.split(", ").map(Number);  // Chuyển chuỗi thành mảng số
            } else {
                data[key] = value;
            }
        });
        data['rentArea'] = rentArea;
        data['type'] = type.toString();
        return data;
    }

    function isValidData(data) {
        const requiredFields = ['productName', 'street', 'ward', 'district', 'rentPrice'];

        for (const field of requiredFields) {
            if (!data[field] || data[field].trim() === "") {
                alert(`Vui lòng điền đầy đủ thông tin:` + field);
                return false;
            }
        }
        return true;
    }

    function fetchAPI(url, data) {
        fetch(url, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(data),
        }).then((response) => {
            if (!response.ok) {
                throw new Error(`HTTP status ${response.status}`);
            }
            // Kiểm tra Content-Type hoặc Response Body
            const contentType = response.headers.get("Content-Type");
            if (response.status === 204 || !contentType || contentType.indexOf("application/json") === -1) {
                return null; // Không parse JSON nếu không có nội dung
            }
            return response.json();
        }).then((result) => {
            console.log("Success:", result); // Xử lý kết quả trả về
            alert("Cập nhật thành công!"); // Thêm thông báo cho người dùng
        })
            .catch((error) => {
                console.error("Failed:", error); // Xử lý lỗi
                alert("Đã xảy ra lỗi, vui lòng thử lại.");
            });
    }

</script>
</body>


</html>
