import {useNavigate} from 'react-router-dom';
import {useForm} from "react-hook-form";
import {zodResolver} from "@hookform/resolvers/zod";
import {contactSchema} from "./contactSchema.js";
import {Button, Card, Form} from "react-bootstrap";
const FormContact = () => {
    const navigate = useNavigate();
    const {register, handleSubmit, formState: {errors}} = useForm(
        {resolver: zodResolver(contactSchema),
        mode: "onBlur"}
    );
    const onSubmit = (data) => {
        console.log(data, ' has been submitted');
        navigate("/success");
    }
    return (
        <div className="d-flex justify-content-center">
            <Card className="mt-5 shadow-sm" style={{width: '30rem'}}>
                <Card.Header className="bg-primary text-light fw-bold">Contact Form</Card.Header>
                <Card.Body>
                    <Form onSubmit={handleSubmit(onSubmit)}>
                        <Form.Group>
                            <Form.Label>Name</Form.Label>
                            <Form.Control {...register('name')} isInvalid={!!errors.name} />
                            <Form.Control.Feedback type="invalid">{errors.name?.message}</Form.Control.Feedback>
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Email</Form.Label>
                            <Form.Control {...register('email')} isInvalid={!!errors.email} />
                            <Form.Control.Feedback type="invalid">{errors.email?.message}</Form.Control.Feedback>
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Phone</Form.Label>
                            <Form.Control {...register('phone')} isInvalid={!!errors.phone} />
                            <Form.Control.Feedback type="invalid">{errors.phone?.message}</Form.Control.Feedback>
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Message</Form.Label>
                            <Form.Control {...register('message')} isInvalid={!!errors.message} />
                            <Form.Control.Feedback type="invalid">{errors.message?.message}</Form.Control.Feedback>
                        </Form.Group>
                        <div className="mt-3 d-flex justify-content-center">
                            <Button variant="secondary" type="submit">Submit</Button>
                        </div>
                    </Form>
                </Card.Body>
            </Card>
        </div>
    )
}

export default FormContact;