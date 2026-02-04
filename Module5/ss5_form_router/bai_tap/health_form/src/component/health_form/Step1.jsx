import {useNavigate} from "react-router-dom";
import {useForm} from "react-hook-form";
import {zodResolver} from "@hookform/resolvers/zod";
import {UserInfoSchema} from "./ValidationSchema.js";
import {Button, Card, CardBody, CardHeader, Form, FormControl, FormGroup, FormLabel} from "react-bootstrap";

const Step1 = () => {
    const navigate = useNavigate();
    const {register, handleSubmit, formState: {errors}} = useForm({
        resolver: zodResolver(UserInfoSchema),
        mode: 'onBlur',
        defaultValues: {
            gender: ""
        },
    });
    console.log(errors);
    const onSubmit = (info) => {
        console.log(info);
        navigate("/step2");
    };
    return (
        <div className='d-flex justify-content-center'>
            <Card className='my-5 shadow-sm' style={{width: '30rem'}}>
                <CardHeader className="bg-dark fw-bold text-light fs-3">
                    Tờ khai y tế
                </CardHeader>
                <CardBody>
                    <Form onSubmit={handleSubmit(onSubmit)}>
                        <Form.Group>
                            <Form.Label column="lg">Họ tên</Form.Label>
                            <Form.Control {...register("name")} isInvalid={!!errors.name}></Form.Control>
                            <Form.Control.Feedback type="invalid">{errors.name?.message}</Form.Control.Feedback>
                        </Form.Group>
                        <Form.Group>
                            <Form.Label column="lg">Số hộ chiếu</Form.Label>
                            <Form.Control {...register("passport")} isInvalid={!!errors.passport}></Form.Control>
                            <Form.Control.Feedback type="invalid">{errors.passport?.message}</Form.Control.Feedback>
                        </Form.Group>
                        <Form.Group>
                            <Form.Label column="lg">Năm sinh</Form.Label>
                            <Form.Control type="date" {...register("dob")} isInvalid={!!errors.dob}></Form.Control>
                            <Form.Control.Feedback type="invalid">{errors.dob?.message}</Form.Control.Feedback>
                        </Form.Group>
                        <Form.Group>
                            <Form.Label column='lg'>Giới tính</Form.Label>
                            <div>
                                <Form.Check inline='true' type='radio' label='Nam' value='male' {...register("gender")} id='gender-m'></Form.Check>
                                <Form.Check inline='true' type='radio' label='Nữ' value='female' {...register("gender")} id='gender-fm'></Form.Check>
                                <Form.Check inline='true' type='radio' label='Khác' value='other' {...register("gender")} id={'gender-o'}></Form.Check>
                            </div>
                            {errors.gender && (
                                <div className="text-danger small mt-1">
                                    {errors.gender.message}
                                </div>
                            )}
                        </Form.Group>
                        <Form.Group>
                            <Form.Label column='lg'>Quốc tịch</Form.Label>
                            <Form.Control {...register("nationality")} isInvalid={!!errors.nationality}></Form.Control>
                            <Form.Control.Feedback type="invalid">{errors.nationality?.message}</Form.Control.Feedback>
                        </Form.Group>
                        <Form.Group>
                            <Form.Label column='lg'>Công ty làm việc</Form.Label>
                            <Form.Control {...register("company")} isInvalid={!!errors.company}></Form.Control>
                            <Form.Control.Feedback type="invalid">{errors.company?.message}</Form.Control.Feedback>
                        </Form.Group>
                        <Form.Group>
                            <Form.Label column='lg'>Bộ phận làm việc</Form.Label>
                            <Form.Control {...register("department")} isInvalid={!!errors.department}></Form.Control>
                            <Form.Control.Feedback type="invalid">{errors.department?.message}</Form.Control.Feedback>
                        </Form.Group>
                        <Form.Group>
                            <div>
                                <Form.Label column='lg' inline='true'>Có thẻ bảo hiểm y tế </Form.Label>
                                <Form.Check type='checkbox' {...register('hasInsurance')} className='ps-3' inline='true'></Form.Check>
                            </div>
                        </Form.Group>
                        <Form.Label column='lg' className='fw-bold'>Địa chỉ liên lạc tại Việt Nam</Form.Label>
                        <Form.Group>
                            <Form.Label column='lg'>Tỉnh thành</Form.Label>
                            <Form.Control {...register("province")} isInvalid={!!errors.province}></Form.Control>
                            <Form.Control.Feedback type="invalid">{errors.province?.message}</Form.Control.Feedback>
                        </Form.Group>
                        <Form.Group>
                            <Form.Label column='lg'>Quận/huyện</Form.Label>
                            <Form.Control {...register("district")} isInvalid={!!errors.district}></Form.Control>
                            <Form.Control.Feedback type="invalid">{errors.district?.message}</Form.Control.Feedback>
                        </Form.Group>
                        <Form.Group>
                            <Form.Label column='lg'>Phường/xã</Form.Label>
                            <Form.Control {...register("ward")} isInvalid={!!errors.ward}></Form.Control>
                            <Form.Control.Feedback type="invalid">{errors.ward?.message}</Form.Control.Feedback>
                        </Form.Group>
                        <Form.Group>
                            <Form.Label column='lg'>Số nhà, phố, tổ dân phố/thôn/đội</Form.Label>
                            <Form.Control {...register("address")} isInvalid={!!errors.address}></Form.Control>
                            <Form.Control.Feedback type="invalid">{errors.address?.message}</Form.Control.Feedback>
                        </Form.Group>
                        <Form.Group>
                            <Form.Label column='lg'>Điện thoại</Form.Label>
                            <Form.Control {...register("phone")} isInvalid={!!errors.phone}></Form.Control>
                            <Form.Control.Feedback type="invalid">{errors.phone?.message}</Form.Control.Feedback>
                        </Form.Group>
                        <Form.Group>
                            <Form.Label column='lg'>Email</Form.Label>
                            <Form.Control {...register("email")} isInvalid={!!errors.email}></Form.Control>
                            <Form.Control.Feedback type="invalid">{errors.email?.message}</Form.Control.Feedback>
                        </Form.Group>
                        <div className="d-flex justify-content-center mt-3">
                            <Button variant="primary" type="submit">Submit</Button>
                        </div>
                    </Form>
                </CardBody>
            </Card>
        </div>
    );
}
export default Step1;