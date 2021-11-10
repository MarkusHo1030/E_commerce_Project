import React from 'react';
import {Button, Card, Carousel, Container} from 'react-bootstrap';
import Navbar from "../../component/Navbar";
import "./index.css";
import {ProductListItem} from "../../../data/product";
import {getAllProducts} from "../../../resource/productResource";
import {Link, RouteComponentProps, withRouter} from 'react-router-dom';

type Props = RouteComponentProps & {};
type State = {
    products: ProductListItem[] | undefined
};

class ProductListingPage extends React.Component<Props, State> {
    constructor(props: Props) {
        super(props);

        this.state = {
            products: undefined
        };

        this.onLoadedProductList = this.onLoadedProductList.bind(this);
    }

    componentDidMount() {
        getAllProducts(this.onLoadedProductList);
    }

    onLoadedProductList(isSuccess: boolean, data: ProductListItem[] | string) {
        if (isSuccess) {
            this.setState({
                products: data as ProductListItem[]
            })
        } else {
            alert(data);
        }
    }

    render() {
        return (
            <div className="productListingPage">
                <Navbar/>
                <Container>
                    <div className="carousel">
                <Carousel fade>
                    <Carousel.Item>
                        <img
                            className="block"
                            src="https://skins.co.za/media/wysiwyg/YoungRose-EdP-2x1-3.jpg"
                            alt=" "
                        />
                        <Carousel.Caption>

                        </Carousel.Caption>
                    </Carousel.Item>
                    <Carousel.Item>
                        <img
                            className="block"
                            src="https://media.gq.com.tw/photos/5fb49c55e3d194c511bc6140/master/w_2000,h_1000,c_limit/BYREDO%20%E8%8F%B8%E7%86%85%E8%AC%8E%E6%83%85%E5%A5%A2%E8%8F%AF%E9%A6%99%E7%B2%BE%20(4).jpg"
                            alt=" "
                        />

                        <Carousel.Caption>

                        </Carousel.Caption>
                    </Carousel.Item>
                    <Carousel.Item>
                        <img
                            className="block"
                            src="https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/030121-worth-it-byredo-index-1614703890.jpg"
                            alt=" "
                        />

                        <Carousel.Caption>

                        </Carousel.Caption>
                    </Carousel.Item>
                    <Carousel.Item>
                        <img
                            className="block"
                            src="https://hips.hearstapps.com/esq.h-cdn.co/assets/17/23/1496696036-es-060517-style-mens-fashion-ben-gorhambyredo.jpg"
                            alt=" "
                        />

                        <Carousel.Caption>
                        </Carousel.Caption>
                    </Carousel.Item>
                    <Carousel.Item>
                        <img
                            className="block"
                            src="https://tietheknotshk.files.wordpress.com/2020/04/byredo_sundazed_photographed-by-craig-mcdean-art-directed-by-mm-paris_2.jpg"
                            alt=" "
                        />

                        <Carousel.Caption>

                        </Carousel.Caption>
                    </Carousel.Item>
                </Carousel>
                    <br/>
                </div>



                    <div className="d-flex flex-row justify-content-center flex-wrap">
                        {
                            this.state.products?.map((item) => (
                                <Card
                                    className="item"
                                    key={item.pid}
                                    style={{width: '18rem'}}
                                >
                                    <div
                                        className="image"
                                        style={{
                                            backgroundImage: `url('${item.imageUrl}')`,
                                        }}
                                    />

                                    <Card.Body>
                                        <Card.Title>{item.name}</Card.Title>
                                        <Card.Text>${item.price}</Card.Text>
                                        <Button
                                            variant="primary"
                                            onClick={() => {
                                                this.props.history.push(`/details/${item.pid}/${item.name}`);
                                            }}
                                        >
                                            View Details
                                        </Button>
                                    </Card.Body>
                                </Card>
                            ))
                        }

                    </div>
                </Container>
            </div>
        );
    }
}

export default withRouter(ProductListingPage);