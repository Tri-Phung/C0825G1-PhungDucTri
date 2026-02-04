import {useNavigate} from "react-router-dom";
import {useForm} from "react-hook-form";
import {zodResolver} from "@hookform/resolvers/zod";
import {HealthFormSchema} from "./ValidationSchema.js";
import {Button, Card, CardBody, CardHeader, Form} from "react-bootstrap";

const Step2 = () => {
    const navigate = useNavigate();
    const {register, handleSubmit, formState: {errors}} = useForm({
        resolver: zodResolver(HealthFormSchema),
        mode: "onBlur",
        defaultValues: {
            symptoms: [],
            contact: []
        }
    });
    console.log(errors);
    const onSubmit = (data) => {
        console.log(data);
        navigate('/success');
    }
    return (
        <div className='d-flex justify-content-center'>
            <Card className='my-5 shadow-sm' style={{width: '30rem'}}>
                <CardHeader className="bg-dark fw-bold text-light fs-3">
                    Thông tin sàng lọc
                </CardHeader>
                <CardBody>
                    <Form onSubmit={handleSubmit(onSubmit)}>
                        <Form.Group>
                            <Form.Label column="lg">Trong vòng 14 ngày qua, Anh /Chị
                                có đến quốc gia /vùng lãnh thổ
                                nào (Có thể đi qua nhiều quốc
                                gia)</Form.Label>
                            <Form.Control as="textarea" {...register("countries")} isInvalid={!!errors.countries}></Form.Control>
                            <Form.Control.Feedback type="invalid">{errors.countries?.message}</Form.Control.Feedback>
                        </Form.Group>
                        <Form.Group>
                            <Form.Label column="lg">Trong vòng 14 ngày qua, Anh /Chị
                                có thấy xuất hiện dấu hiệu nào
                                sau đây không?</Form.Label>
                            <div>
                                <Form.Check type='checkbox' label='Sốt' value='sick' {...register("symptoms")}
                                            id='sick'></Form.Check>
                                <Form.Check type='checkbox' label='Ho' value='cough' {...register("symptoms")}
                                            id='cough'></Form.Check>
                                <Form.Check type='checkbox' label='Khó thở'
                                            value='dyspnea' {...register("symptoms")} id={'dyspnea'}></Form.Check>
                                <Form.Check type='checkbox' label='Viêm phổi'
                                            value='pneumonia' {...register("symptoms")} id={'pneumonia'}></Form.Check>
                                <Form.Check type='checkbox' label='Đau họng'
                                            value='sore throat' {...register("symptoms")}
                                            id={'sore-throat'}></Form.Check>
                                <Form.Check type='checkbox' label='Mệt mỏi' value='tired' {...register("symptoms")}
                                            id={'tired'}></Form.Check>
                            </div>
                        </Form.Group>
                        <Form.Group>
                            <Form.Label column="lg">Trong vòng 14 ngày qua, Anh /Chị
                                có tiếp súc với?</Form.Label>
                            <div>
                                <Form.Check type='checkbox' label='Người bệnh hoặc nghi ngờ, mắc bệnh
                                    COVID-19' value='with patient' {...register("contact")}
                                            id='with-patient'></Form.Check>
                                <Form.Check type='checkbox' label='Người từ nước có bệnh COVID-19' value='with people from outbreak area' {...register("contact")}
                                            id='with-people-o'></Form.Check>
                                <Form.Check type='checkbox' label='Người có biểu hiện (Sốt, ho, khó thờ,
                                    viêm phổi)' value='with suspected case' {...register("contact")}
                                            id={'with-sus-c'}></Form.Check>
                            </div>
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
export default Step2;