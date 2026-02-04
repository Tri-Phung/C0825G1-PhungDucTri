import {z} from 'zod';
export const contactSchema = z.object({
    name: z.string().min(1,"Name is required"),
    email: z.email("Invalid email address")
        .regex(/^[a-zA-Z0-9+-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/,"Invalid email address"),
    phone: z.string().regex(/^[0-9]{10,11}$/,"Invalid phone number"),
    message: z.string().min(1,"Message is required")
});