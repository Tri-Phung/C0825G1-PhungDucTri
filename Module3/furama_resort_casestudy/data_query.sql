use furama_resort;

-- Thực hiện truy vấn theo yêu cầu sau:
-- 1.	Thêm mới thông tin cho tất cả các bảng có trong CSDL để có thể thõa mãn các yêu cầu bên dưới.

-- trinh_do
INSERT INTO trinh_do (trinh_do) VALUES
('Trung cap'),('Cao dang'),('Dai hoc'),('Sau dai hoc');

-- vi_tri
INSERT INTO vi_tri (ten_vi_tri) VALUES
('Le tan'),('Phuc vu'),('Chuyen vien'),('Giam sat'),('Quan ly'),('Giam doc');

-- bo_phan
INSERT INTO bo_phan (ten_bo_phan) VALUES
('Sale - Marketing'),('Hanh chinh'),('Phuc vu'),('Quan ly');

-- loai_khach
INSERT INTO loai_khach (ten_loai_khach) VALUES
('Diamond'),('Platinium'),('Gold'),('Silver'),('Member');

-- loai_dich_vu
INSERT INTO loai_dich_vu (ten_loai_dich_vu) VALUES
('Villa'),('House'),('Room');

-- kieu_thue
INSERT INTO kieu_thue (ten_kieu_thue) VALUES
('Nam'),('Thang'),('Ngay'),('Gio');

-- -----------------------
-- NHÂN VIÊN (có tên bắt đầu H, T, K... có tối đa 15 ký tự)
-- -----------------------
INSERT INTO nhan_vien
(ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi)
VALUES
('Ha Minh', 1, 3, 1, '1990-05-12', '123456789', 9000000, '0901000001', 'ha.minh@furama.vn', 'Da Nang'),
('Hung Tran', 2, 2, 3, '1988-02-03', '223344556', 7000000, '0901000002', 'hung.tran@furama.vn', 'Da Nang'),
('Khoa Nguyen', 3, 3, 2, '1992-07-20', '333444555', 8000000, '0901000003', 'khoa.nguyen@furama.vn', 'Quang Tri'),
('Thao Le', 1, 1, 1, '1995-11-11', '444555666', 6500000, '0901000004', 'thao.le@furama.vn', 'Da Nang'),
('Kim Pham', 4, 4, 4, '1980-01-01', '555666777', 15000000, '0901000005', 'kim.pham@furama.vn', 'Da Nang'),
('Hoang', 2, 2, 3, '1993-03-03', '666777888', 6000000, '0901000006', 'hoang@furama.vn', 'Quang Ngai'),
('Tien Vo', 5, 3, 1, '1985-08-08', '777888999', 10000000, '0901000007', 'tien.vo@furama.vn', 'Vinh'),
('Dang', 2, 2, 2, '1994-04-04', '888999000', 6500000, '0901000008', 'dang@furama.vn', 'Da Nang'),
('Minh', 3, 1, 3, '1991-09-09', '999000111', 7000000, '0901000009', 'minh@furama.vn', 'Quang Tri'),
('Trinh Tran Phuong Tuan', 1, 3, 1, '1990-05-12', '123456789', 9000000, '0901000001', 'ha.minh@furama.vn', 'Ben Tre'),
('Khanh', 1, 1, 1, '1996-10-10', '111222333', 5500000, '0901000010', 'khanh@furama.vn', 'Da Nang');

-- -----------------------
-- KHÁCH HÀNG (đa dạng địa chỉ, tuổi, loại khách)
-- -----------------------
INSERT INTO khach_hang
(ho_ten, ngay_sinh, gioi_tinh, so_cmtnd, sdt, email, id_loai_khach, dia_chi)
VALUES
('Nguyen Van A', '1985-06-01', 'Nam', 'A1234567', '0911000001', 'a@example.com', 1, 'Hai Chau, Da Nang'),
('Tran Thi B', '1999-07-15', 'Nu', 'B1234567', '0911000002', 'b@example.com', 2, 'Cam Le, Da Nang'),
('Le Van C', '1970-03-20', 'Nam', 'C1234567', '0911000003', 'c@example.com', 3, 'Thanh Khe, Da Nang'),
('Pham Thi D', '1998-12-30', 'Nu', 'D1234567', '0911000004', 'd@example.com', 1, 'Vinh, Nghe An'),
('Hoang Van E', '1995-02-02', 'Nam', 'E1234567', '0911000005', 'e@example.com', 1, 'Quang Tri'),
('Nguyen Thi F', '2002-05-05', 'Nu', 'F1234567', '0911000006', 'f@example.com', 4, 'Quang Tri'),
('Bui Van G', '1990-01-01', 'Nam', 'G1234567', '0911000007', 'g@example.com', 5, 'Da Nang'),
('Dao Thi H', '1988-08-08', 'Nu', 'H1234567', '0911000008', 'h@example.com', 2, 'Quang Ngai'),
('Nguyen Van I', '1975-11-11', 'Nam', 'I1234567', '0911000009', 'i@example.com', 1, 'Hue'),
('Vo Thi K', '2000-10-10', 'Nu', 'K1234567', '0911000010', 'k@example.com', 2, 'Da Nang'),
('Le Thi L', '1989-09-09', 'Nu', 'L1234567', '0911000011', 'l@example.com', 1, 'Vinh'),
('Tran Van M', '1996-04-04', 'Nam', 'M1234567', '0911000012', 'm@example.com', 3, 'Da Nang');

-- -----------------------
-- DỊCH VỤ (Villa / House / Room)
-- -----------------------
-- Loai_dich_vu: 1-Villa,2-House,3-Room
INSERT INTO dich_vu
(ten_dich_vu, dien_tich, chi_phi_thue, so_nguoi_toi_da, id_kieu_thue, id_loai_dich_vu,
 tieu_chuan_phong, mo_ta_tien_nghi, dien_tich_ho_boi, so_tang, dich_vu_mien_phi_di_kem)
VALUES
('Furama Sea Villa A', 350, 5000000, 8, 3, 1, '5-star', 'Full service, breakfast, private pool', 50, 2, NULL),
('Furama Sea Villa B', 300, 4500000, 6, 3, 1, '5-star', 'Sea view, private pool', 40, 2, NULL),
('Furama House Family', 120, 1500000, 4, 3, 2, '4-star', 'Kitchenette', NULL, 2, NULL),
('Garden House', 100, 1200000, 4, 3, 2, '3-star', 'Garden view', NULL, 2, NULL),
('Deluxe Room Sea', 35, 500000, 2, 3, 3, NULL, NULL, NULL, NULL, 'Welcome drink'),
('Superior Room', 28, 350000, 2, 3, 3, NULL, NULL, NULL, NULL, 'Breakfast'),
('Family Room', 45, 700000, 4, 3, 3, NULL, NULL, NULL, NULL, 'Breakfast');

-- -----------------------
-- DỊCH VỤ ĐI KÈM
-- -----------------------
INSERT INTO dich_vu_di_kem (ten_dich_vu_di_kem, don_vi, gia) VALUES
('Massage 60min', 'Buoi', 300000),
('Karaoke 1gio', 'Gio', 200000),
('Set Buffet 1 nguoi', 'Nguoi', 150000),
('Nuoc Ngot 330ml', 'Chai', 20000),
('Thue Xe 4 cho', 'Chuyen', 500000),
('Thue Xe 7 cho', 'Chuyen', 800000),
('Tour Ban Ngay', 'Nguoi', 300000),
('Spa 90min', 'Buoi', 450000);

-- ####################
-- HỢP ĐỒNG MẪU (2015-2019)
-- ####################
-- Tạo hợp đồng cho nhiều khách, nhiều năm, nhiều dịch vụ và dịch vụ đi kèm
-- Một số hợp đồng dùng nhiều dịch vụ đi kèm (ghi vào hop_dong_chi_tiet)

INSERT INTO hop_dong (id_nhan_vien,id_khach_hang,id_dich_vu,ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc,tong_tien)
VALUES
-- 2018 bookings
(1, 1, 1, '2018-02-10', '2018-02-20', 1000000, 5000000),
(2, 2, 5, '2018-03-05', '2018-03-07', 200000, 700000),
(3, 3, 3, '2018-07-01', '2018-07-05', 300000, 1500000),

-- 2019 bookings (various months)
(1, 1, 2, '2019-01-15', '2019-01-20', 2000000, 6000000),
(5, 4, 1, '2019-02-05', '2019-02-15', 1500000, 4800000),
(7, 5, 6, '2019-03-10', '2019-03-12', 250000, 800000),
(2, 6, 4, '2019-04-20', '2019-04-25', 300000, 1200000),
(8, 7, 3, '2019-06-01', '2019-06-03', 200000, 750000),
(9, 8, 5, '2019-09-10', '2019-09-13', 500000, 1500000),
(3, 9, 7, '2019-11-20', '2019-11-25', 700000, 3500000),
(4, 10, 2, '2019-10-05', '2019-10-10', 800000, 3000000),

-- some earlier/later years to test deletions (2015,2016,2017,2014)
(6, 11, 6, '2016-05-01', '2016-05-03', 200000, 600000),
(7, 12, 4, '2015-12-20', '2016-01-02', 500000, 1800000),
(1, 2, 3, '2014-07-07', '2014-07-10', 100000, 400000),
(10, 1, 5, '2019-12-05', '2019-12-08', 300000, 900000),
(1, 1, 1, '2019-12-20', '2020-01-02', 2000000, 10000000);

-- hop_dong_chi_tiet : liên kết dịch vụ đi kèm với hợp đồng
INSERT INTO hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong, gia_tai_thoi_diem) VALUES
-- contract 1 (2018-02-10)
(1, 1, 2, 300000), -- Massage x2
(1, 3, 4, 150000), -- Buffet x4

-- contract 2 (2018-03-05)
(2, 4, 6, 20000),

-- contract 3 (2018-07-01)
(3, 5, 1, 500000),

-- contract 4 (2019-01-15)
(4, 7, 2, 300000),
(4, 4, 10, 20000),

-- contract 5 (2019-02-05)
(5, 1, 1, 300000),
(5, 2, 3, 200000),

-- contract 6 (2019-03-10)
(6, 3, 2, 150000),
(6, 4, 2, 20000),

-- contract 7 (2019-04-20)
(7, 8, 1, 450000),

-- contract 8 (2019-06-01)
(8, 6, 1, 800000),

-- contract 9 (2019-09-10)
(9, 3, 3, 150000),
(9, 4, 5, 20000),

-- contract 10 (2019-11-20)
(10, 1, 5, 300000),
(10, 7, 2, 300000),

-- contract 11 (2019-10-05)
(11, 2, 4, 200000),
(11, 4, 10, 20000),

-- older contracts
(12, 4, 2, 200000),
(13, 3, 6, 200000),

-- contract 14 (2019-12-05)
(14, 3, 1, 150000),
-- contract 15 (2019-12-20)
(15, 1, 2, 300000),
(15, 2, 1, 200000),
(15, 4, 20, 20000);


-- 2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.

select ho_ten, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi
from nhan_vien
where (ho_ten like 'H%' or ho_ten like 'T%' or ho_ten like 'K%') and char_length(ho_ten) <= 15;

-- 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.

select ho_ten, ngay_sinh, gioi_tinh, so_cmtnd, sdt, email, dia_chi
from khach_hang
where timestampdiff(year,ngay_sinh,curdate()) between 18 and 50 and (dia_chi like '%Da Nang%' or dia_chi like '%Quang Tri%');

-- 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.

select k.id_khach_hang, k.ho_ten, count(k.id_khach_hang) as so_lan_dat_phong
from loai_khach l
join khach_hang k on l.id_loai_khach = k.id_loai_khach
join hop_dong h on k.id_khach_hang = h.id_khach_hang
where l.ten_loai_khach = 'Diamond'
group by k.id_khach_hang
order by so_lan_dat_phong;

-- 5.	Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien (Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem) cho tất cả các Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).

 select kh.id_khach_hang, kh.ho_ten, lk.ten_loai_khach, hd.id_hop_dong, dv.ten_dich_vu, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, (dv.chi_phi_thue + ifnull(sum(hdct.so_luong * dvdk.gia),0)) as tong_tien
 from khach_hang kh
 left join loai_khach lk on kh.id_loai_khach = lk.id_loai_khach
 left join hop_dong hd on kh.id_khach_hang = hd.id_khach_hang
 left join dich_vu dv on hd.id_dich_vu = dv.id_dich_vu
 left join hop_dong_chi_tiet hdct on hd.id_hop_dong = hdct.id_hop_dong
 left join dich_vu_di_kem dvdk on hdct.id_dich_vu_di_kem = dvdk.id_dich_vu_di_kem
 group by kh.id_khach_hang, kh.ho_ten, lk.ten_loai_khach, hd.id_hop_dong, dv.ten_dich_vu, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc;

-- 6.	Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các loại Dịch vụ chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).

select dv.id_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.chi_phi_thue, ldv.ten_loai_dich_vu
from dich_vu dv
left join loai_dich_vu ldv on dv.id_loai_dich_vu = ldv.id_loai_dich_vu
left join hop_dong hd on dv.id_dich_vu = hd.id_dich_vu
and year(hd.ngay_lam_hop_dong) = 2019
and month(hd.ngay_lam_hop_dong) in (1,2,3)
where hd.id_hop_dong is null;

-- 7.	Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu của tất cả các loại dịch vụ đã 
-- từng được Khách hàng đặt phòng trong năm 2018 nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019.

select distinct dv.id_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.so_nguoi_toi_da, dv.chi_phi_thue, ldv.ten_loai_dich_vu
from dich_vu dv
join loai_dich_vu ldv on dv.id_loai_dich_vu = ldv.id_loai_dich_vu
join hop_dong hd on dv.id_dich_vu = hd.id_dich_vu
join khach_hang kh on hd.id_khach_hang = kh.id_khach_hang
where year(hd.ngay_lam_hop_dong) = 2018
and kh.id_khach_hang not in (
	select id_khach_hang
    from hop_dong
    where year(ngay_lam_hop_dong) = 2019
);


-- 8.	Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau.
-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên

select distinct ho_ten
from khach_hang;

select ho_ten
from khach_hang
group by ho_ten;

select ho_ten
from khach_hang kh1
where ho_ten in (
	select ho_ten
    from khach_hang kh2
    where kh2.ho_ten = kh1.ho_ten
    and kh2.id_khach_hang < kh1.id_khach_hang
);

-- 9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2019 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.

select month(ngay_lam_hop_dong) as thang, count(id_khach_hang) as so_luong_khach_hang
from hop_dong
where year(ngay_lam_hop_dong) = 2019
group by month(ngay_lam_hop_dong)
order by thang;

-- 10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. Kết quả hiển thị bao gồm 
-- IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem (được tính dựa trên việc count các IDHopDongChiTiet).

select hd.id_hop_dong, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, hd.tien_dat_coc, count(hdct.id_hop_dong_chi_tiet) as so_luong_dv_di_kem
from hop_dong hd
join hop_dong_chi_tiet hdct on hd.id_hop_dong = hdct.id_hop_dong
group by hd.id_hop_dong, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, hd.tien_dat_coc;

-- 11.	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có TenLoaiKhachHang là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.

select dvdk.id_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem
from hop_dong hd
join khach_hang kh on hd.id_khach_hang = kh.id_khach_hang
join loai_khach lk on kh.id_loai_khach = lk.id_loai_khach
join hop_dong_chi_tiet hdct on hd.id_hop_dong = hdct.id_hop_dong
join dich_vu_di_kem dvdk on hdct.id_dich_vu_di_kem = dvdk.id_dich_vu_di_kem
where lk.ten_loai_khach = 'Diamond' and kh.dia_chi in ('Vinh','Quang Ngai');

-- 12.	Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem (được tính dựa trên tổng Hợp đồng chi tiết), 
-- TienDatCoc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2019 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019.

select hd.id_hop_dong, nv.ho_ten as ten_nhan_vien, kh.ho_ten as ten_khach_hang, kh.sdt as so_dien_thoai_khach_hang, dv.ten_dich_vu, ifnull(sum(hdct.so_luong),0) as so_luong_dich_vu_di_kem, hd.tien_dat_coc
from hop_dong hd
join nhan_vien nv on hd.id_nhan_vien = nv.id_nhan_vien
join khach_hang kh on hd.id_khach_hang = kh.id_khach_hang
join dich_vu dv on hd.id_dich_vu = dv.id_dich_vu
left join hop_dong_chi_tiet hdct on hd.id_hop_dong = hdct.id_hop_dong
where year(hd.ngay_lam_hop_dong) = 2019 and month(hd.ngay_lam_hop_dong) in (10,11,12) 
and dv.id_dich_vu not in (
	select hd2.id_dich_vu
    from hop_dong hd2
    where year(hd2.ngay_lam_hop_dong) = 2019 and month(hd2.ngay_lam_hop_dong) between 1 and 6
)
group by hd.id_hop_dong, nv.ho_ten, kh.ho_ten, kh.sdt, dv.ten_dich_vu, hd.tien_dat_coc
order by hd.id_hop_dong;

-- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).

select dvdk.id_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem, sum(hdct.so_luong) as so_luong_dich_vu_di_kem
from hop_dong_chi_tiet hdct
join dich_vu_di_kem dvdk on hdct.id_dich_vu_di_kem = dvdk.id_dich_vu_di_kem
group by dvdk.id_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem
having sum(hdct.so_luong) = (
	select max(tong_su_dung)
    from (
		select sum(hdct2.so_luong) as tong_su_dung
        from hop_dong_chi_tiet hdct2
        group by hdct2.id_dich_vu_di_kem
    ) as temp
);

-- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.

select hdct.id_hop_dong, ldv.ten_loai_dich_vu, dvdk.ten_dich_vu_di_kem, sum(hdct.so_luong) as so_lan_su_dung
from hop_dong_chi_tiet hdct
join hop_dong hd on hdct.id_hop_dong = hd.id_hop_dong
join dich_vu dv on dv.id_dich_vu = hd.id_dich_vu
join loai_dich_vu ldv on ldv.id_loai_dich_vu = dv.id_loai_dich_vu
join dich_vu_di_kem dvdk on dvdk.id_dich_vu_di_kem = hdct.id_dich_vu_di_kem
group by hdct.id_hop_dong, ldv.ten_loai_dich_vu, dvdk.ten_dich_vu_di_kem
having sum(hdct.so_luong) = 1;

-- 15.	Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai, DiaChi mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.

select nv.id_nhan_vien, nv.ho_ten, td.trinh_do, bp.ten_bo_phan, nv.sdt, nv.dia_chi
from nhan_vien nv
join bo_phan bp on nv.id_bo_phan = bp.id_bo_phan
join trinh_do td on nv.id_trinh_do = td.id_trinh_do
left join hop_dong hd on nv.id_nhan_vien = hd.id_nhan_vien and year(hd.ngay_lam_hop_dong) between 2018 and 2019
group by nv.id_nhan_vien, nv.ho_ten, td.trinh_do, bp.ten_bo_phan, nv.sdt, nv.dia_chi
having count(hd.id_hop_dong) <= 3;

-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.

delete from nhan_vien
where id_nhan_vien not in (
	select distinct id_nhan_vien
    from hop_dong
    where year(ngay_lam_hop_dong) between 2017 and 2019
);

-- 17.	Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond, chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ.

update khach_hang
set id_loai_khach = 'Diamond'
where id_loai_khach = (
    select id_loai_khach from loai_khach where ten_loai_khach = 'Platinium'
)
and id_khach_hang in (
    select hd.id_khach_hang
    from hop_dong hd
    join hop_dong_chi_tiet hdct on hd.id_hop_dong = hdct.id_hop_dong
    where year(hd.ngay_lam_hop_dong) = 2019
    group by hd.id_khach_hang
    having sum(hdct.gia_tai_thoi_diem) > 10000000
);

-- 18.	Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràngbuộc giữa các bảng).

delete from hop_dong_chi_tiet
where id_hop_dong in (
    select id_hop_dong
    from hop_dong
    where year(ngay_lam_hop_dong) < 2016
);

delete from hop_dong
where year(ngay_lam_hop_dong) < 2016;

delete from khach_hang
where id_khach_hang in (
    select id_khach_hang
    from hop_dong
    where year(ngay_lam_hop_dong) < 2016
);


-- 19.	Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi.

update dich_vu_di_kem
set gia = gia * 2
where id_dich_vu_di_kem in (
    select hdct.id_dich_vu_di_kem
    from hop_dong_chi_tiet hdct
    join hop_dong hd on hdct.id_hop_dong = hd.id_hop_dong
    where year(hd.ngay_lam_hop_dong) = 2019
    group by hdct.id_dich_vu_di_kem
    having sum(hdct.so_luong) > 10
);


-- 20.	Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống, thông tin hiển thị bao gồm ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi.

select 
    nv.id_nhan_vien as id,
    nv.ho_ten as ho_ten,
    nv.email,
    nv.sdt,
    nv.ngay_sinh,
    nv.dia_chi,
    'Nhan Vien' as loai
from nhan_vien nv

union

select 
    kh.id_khach_hang as id,
    kh.ho_ten as ho_ten,
    kh.email,
    kh.sdt,
    kh.ngay_sinh,
    kh.dia_chi,
    'Khach Hang' as loai
FROM khach_hang kh;

