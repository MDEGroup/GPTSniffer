



 ParallaxPageTransformer pageTransformer = new ParallaxPageTransformer()
                .addViewToParallax(new ParallaxTransformInformation(R.id.img_background, 2, 2))
                .addViewToParallax(new ParallaxTransformInformation(R.id.tutorial_img_phone, -0.65f,
                        PARALLAX_EFFECT_DEFAULT));
  mViewPager.setPageTransformer(true, pageTransformer);
